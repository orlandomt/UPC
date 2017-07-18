package com.springboot.repository.jdbc;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springboot.config.WhereParams;
import com.springboot.model.ReservaFilter;
import com.springboot.model.ReservaResult;

@Repository
public class ReservaJdbcRepository {
	
	@Autowired
    DataSource dataSource;

    private NamedParameterJdbcTemplate jdbcTemplate;
    
    private String getdate;

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

        sql.append(" SELECT ");
        sql.append(" re.cod_reserva AS cod_reserva, ");
        sql.append(" re.fecha_reserva AS fecha_reserva, ");
        sql.append(" re.tipo_reserva AS tipo_reserva, ");
        sql.append(" re.dni AS dni, ");
        sql.append(" re.motivo AS motivo, ");
        sql.append(" re.hora AS hora, ");
        sql.append(" cl.nombre AS nombre_cliente, ");
        sql.append(" re.cod_local AS local, ");
        sql.append(" cl.nombre AS nombre_cliente, ");        
        sql.append(" re.estado AS estado ");
        sql.append(" FROM reserva re ");
        sql.append(" LEFT JOIN cliente cl ON re.dni = cl.dni ");
        sql.append(" WHERE 1=1 ");

//        sql.append(params.filter(" AND UN.IdUnidadDeNegocio = :unidadNegocio ", filterViewModel.getUnidadNegocio()));
//        sql.append(params.filter(" AND DEP.IdDepartamentoArea = :departamento ", filterViewModel.getDepartamento()));
//        sql.append(params.filter(" AND PROY.IdProyecto = :proyecto ", filterViewModel.getProyecto()));
//
//        sql.append(params.filter(" AND MAR.Fecha = :fecha" , filterViewModel.getFecha()));
        
//        sql.append(" Order by nombreCompletoEmpleado asc,MAR.Fecha desc ");

		return sql.toString();
	}

}
