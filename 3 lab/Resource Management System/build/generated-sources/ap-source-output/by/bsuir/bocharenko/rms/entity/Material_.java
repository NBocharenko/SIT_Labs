package by.bsuir.bocharenko.rms.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Material.class)
public abstract class Material_ {

	public static volatile SingularAttribute<Material, Float> volume;
	public static volatile SingularAttribute<Material, String> measure;
	public static volatile ListAttribute<Material, Supplier> suppliers;
	public static volatile SingularAttribute<Material, Long> id_mat;
	public static volatile SingularAttribute<Material, String> specification;
	public static volatile SingularAttribute<Material, Float> weight;
	public static volatile SingularAttribute<Material, Integer> unitStorageCost;
	public static volatile ListAttribute<Material, Storage> storage;
	public static volatile SingularAttribute<Material, String> title;

}

