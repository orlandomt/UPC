package com.springboot.repository.jdbc;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springboot.config.DateUtil;
import com.springboot.config.WhereParams;
import com.springboot.model.ClienteViewModel;
import com.springboot.model.MesaViewModel;
import com.springboot.model.ReservaFilter;
import com.springboot.model.ReservaResult;
import com.springboot.model.ReservaViewModel;

@Repository
public class ReservaJdbcRepository {
	
	@Autowired
    DataSource dataSource;

    private NamedParameterJdbcTemplate jdbcTemplate;
    
    private String getFechaInicio;
    private String getFechaFin;

    @PostConstruct
    public void init() {
        jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

	public List<ReservaResult> searchReserva(ReservaFilter reservaFilter) {
		WhereParams params = new WhereParams();

        String sql = busquedaReservaQuery(reservaFilter, params);

        return jdbcTemplate.query(sql,
                params.getParams(), new BeanPropertyRowMapper<>(ReservaResult.class));
	}
	private String busquedaReservaQuery(ReservaFilter filterViewModel, WhereParams params) {
		StringBuilder sql = new StringBuilder();
		getFechaInicio = DateUtil.format(new SimpleDateFormat("yyyy-MM-dd"), filterViewModel.getFechaInicio());
		getFechaFin = DateUtil.format(new SimpleDateFormat("yyyy-MM-dd"), filterViewModel.getFechaFin());

        sql.append(" SELECT ");
        sql.append(" re.cod_reserva AS cod_reserva, ");
        sql.append(" re.fecha_reserva AS fecha_reserva, ");
        sql.append(" re.tipo_reserva AS tipo_reserva, ");
        sql.append(" re.dni AS dni, ");
        sql.append(" re.motivo AS motivo, ");
        sql.append(" re.hora AS hora, ");
        sql.append(" me.cod_mesa AS mesa, ");
        sql.append(" re.comentario AS comentario, ");
        sql.append(" cl.nombre AS nombre_cliente, ");
        sql.append(" lo.nombre_local AS nombre_local, ");
        sql.append(" re.cantidad_personas AS cantidad_personas, ");
        sql.append(" cl.nombre AS nombre_cliente, ");        
        sql.append(" re.estado AS estado ");
        sql.append(" FROM reserva re ");
        sql.append(" LEFT JOIN cliente cl ON re.dni = cl.dni ");
        sql.append(" LEFT JOIN local lo ON lo.cod_local = re.cod_local ");
        sql.append(" LEFT JOIN mesa me ON me.cod_mesa = re.cod_mesa ");
        sql.append(" WHERE 1=1 ");

        sql.append(params.filter(" AND cl.ap_paterno = :ap_paterno ", filterViewModel.getAp_paterno()));
        if(filterViewModel.getFechaInicio() != null && filterViewModel.getFechaFin() != null){
        	sql.append(" AND re.fecha_reserva between '"+getFechaInicio+"' AND '"+getFechaFin+"' ");
        }
        
        sql.append(params.filter(" AND cl.nombre = :nombre ", filterViewModel.getNombre()));
        sql.append(params.filter(" AND re.tipo_reserva = :tipo_reserva ", filterViewModel.getTipo_reserva()));
        sql.append(params.filter(" AND lo.nombre_local = :nombre_local ", filterViewModel.getNombre_local()));

		return sql.toString();
	}

	public ClienteViewModel obtenerInformacionClienteByDNI(Long dni) {
		WhereParams params = new WhereParams();
		String sql = obtenerInformacionClienteByDNIQuery(dni, params);
		
//		return jdbcTemplate.queryForObject(sql, params.getParams(),
//				new BeanPropertyRowMapper<ClienteViewModel>(ClienteViewModel.class));
		ClienteViewModel result=new ClienteViewModel();
		List<ClienteViewModel> listaCliente= jdbcTemplate.query(sql, params.getParams(),
				new BeanPropertyRowMapper<ClienteViewModel>(ClienteViewModel.class));
		if(listaCliente!=null && listaCliente.size()>0) {
			result=listaCliente.get(0);
		}
			
		return result;
	}

	private String obtenerInformacionClienteByDNIQuery(Long dni, WhereParams params) {
		
		StringBuilder sql = new StringBuilder();
		
		sql.append(" SELECT ");
        sql.append(" cl.dni AS dni, ");
        sql.append(" cl.nombre AS nombre, ");
        sql.append(" cl.ap_paterno AS ap_paterno, ");
        sql.append(" cl.telefono AS telefono, ");
        sql.append(" cl.correo AS correo ");
        
		sql.append(" FROM cliente cl ");
	    sql.append(" WHERE 1=1 ");
	    sql.append(params.filter(" AND cl.dni = :dni ", dni));

		return sql.toString();
	}

	public MesaViewModel obtenerUltimaReservaClienteByDNI(Long dni) {
		WhereParams params = new WhereParams();
		String sql = obtenerUltimaReservaClienteByDNIQuery(dni, params);
		
		MesaViewModel result=new MesaViewModel();
		List<MesaViewModel> listaUltimaReservaCliente= jdbcTemplate.query(sql, params.getParams(),
				new BeanPropertyRowMapper<MesaViewModel>(MesaViewModel.class));
		if(listaUltimaReservaCliente!=null && listaUltimaReservaCliente.size()>0) {
			result=listaUltimaReservaCliente.get(0);
		}
			
		return result;
	}

	private String obtenerUltimaReservaClienteByDNIQuery(Long dni, WhereParams params) {
		StringBuilder sql = new StringBuilder();
		
		sql.append(" SELECT ");
        sql.append(" me.cod_mesa AS cod_mesa ");
		sql.append(" FROM reserva re ");
		sql.append(" LEFT JOIN mesa me ON re.cod_mesa = me.cod_mesa ");
	    sql.append(" WHERE 1=1 ");
	    sql.append(params.filter(" AND re.dni = :dni ", dni));
	    
	    sql.append(" ORDER BY re.fecha_reserva DESC LIMIT 1 ");

		return sql.toString();
	}

	public List<MesaViewModel> getDisponibilidadMesas(Long dni) {
		WhereParams params = new WhereParams();

        String sql = getDisponibilidadMesasQuery(dni, params);

        return jdbcTemplate.query(sql,
                params.getParams(), new BeanPropertyRowMapper<>(MesaViewModel.class));
	}

	private String getDisponibilidadMesasQuery(Long dni, WhereParams params) {
		StringBuilder sql = new StringBuilder();

        sql.append(" SELECT ");
        sql.append(" re.cod_mesa AS cod_mesa, ");
        sql.append(" re.nombre_mesa AS nombre_mesa, ");
        sql.append(" re.disponibilidad AS disponibilidad, ");
        sql.append(" re.fecha_mesa AS fecha_mesa, ");
        sql.append(" re.hora_mesa AS hora_mesa, ");
        sql.append(" re.sugerencia_mesa AS sugerencia_mesa, ");
        sql.append(" re.reservadoPor_mesa AS reservadoPor_mesa ");
        sql.append(" FROM mesa re ");
        sql.append(" WHERE 1=1 ");

		return sql.toString();
	}
	
	

}
