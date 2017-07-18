package pe.pardoschicken.reserva.service.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import pe.pardoschicken.reserva.config.WhereParams;
import pe.pardoschicken.reserva.model.ReservaFilter;
import pe.pardoschicken.reserva.model.ReservaResult;

public class ReservaJdbcRepository {
	
	@Autowired
    DataSource dataSource;

    private NamedParameterJdbcTemplate jdbcTemplate;
    
    private String getdate;

    @PostConstruct
    public void init() {
        jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

	public List<ReservaResult> busquedaReserva(ReservaFilter reservaFilter) {
		WhereParams params = new WhereParams();

        String sql = busquedaReservaQuery(reservaFilter, params);

        return jdbcTemplate.query(sql,
                params.getParams(), new BeanPropertyRowMapper<>(ReservaResult.class));

	}
	
	private String busquedaReservaQuery(ReservaFilter filterViewModel, WhereParams params) {
		StringBuilder sql = new StringBuilder();

        sql.append(" SELECT * ");
        sql.append(" FROM Reserva MAR ");
        
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
