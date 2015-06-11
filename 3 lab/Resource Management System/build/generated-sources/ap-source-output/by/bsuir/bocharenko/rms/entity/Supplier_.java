package by.bsuir.bocharenko.rms.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Supplier.class)
public abstract class Supplier_ {

	public static volatile SingularAttribute<Supplier, Long> id_sup;
	public static volatile SingularAttribute<Supplier, Material> material;
	public static volatile ListAttribute<Supplier, Orderr> orders;
	public static volatile SingularAttribute<Supplier, Integer> deliveryPrice;
	public static volatile SingularAttribute<Supplier, Integer> resourceUnitPrice;
	public static volatile SingularAttribute<Supplier, String> title;

}

