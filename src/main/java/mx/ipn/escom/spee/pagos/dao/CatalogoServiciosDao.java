package mx.ipn.escom.spee.pagos.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import mx.ipn.escom.spee.pagos.mapeo.ArchivoPagoDia;
import mx.ipn.escom.spee.util.dao.GenericDao;

@Repository("catalogoServiciosDao")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class CatalogoServiciosDao extends GenericDao {
	
	private static final long serialVersionUID = 1L;
	
	public static final String OBTENER_PAGO_DIA = "select * from tp01_pago_dia where fh_envio = current_date";
			
	public static final String OBTENER_PAGO_DIA_AREA = "select pd from ArchivoPagoDia pd RIGHT JOIN CatalogoServicio cs on pd.idCatalogoServicio = cs.idCatalogoServicio where pd.";
	
	
//	@SuppressWarnings("unchecked")
//	public List<ArchivoPagoDia> obtenerPagosPorDia() {
//		Query query = sessionFactory.getCurrentSession().getCriteriaBuilder().createQuery(OBTENER_PAGO_DIA);
//		return query.getResultList();
//	}
	


}
