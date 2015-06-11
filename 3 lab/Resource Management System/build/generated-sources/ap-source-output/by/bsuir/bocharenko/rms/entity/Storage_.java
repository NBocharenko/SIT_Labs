package by.bsuir.bocharenko.rms.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Storage.class)
public abstract class Storage_ {

	public static volatile SingularAttribute<Storage, Material> material;
	public static volatile SingularAttribute<Storage, Date> receiptDate;
	public static volatile SingularAttribute<Storage, Long> id;
	public static volatile SingularAttribute<Storage, Integer> numberOfMaterialUnits;
	public static volatile SingularAttribute<Storage, Float> totalVolumeOfMaterial;

}

