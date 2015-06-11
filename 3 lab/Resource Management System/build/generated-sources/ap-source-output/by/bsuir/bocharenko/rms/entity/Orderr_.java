package by.bsuir.bocharenko.rms.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Orderr.class)
public abstract class Orderr_ {

	public static volatile SingularAttribute<Orderr, Date> execDate;
	public static volatile SingularAttribute<Orderr, Integer> totalVolume;
	public static volatile SingularAttribute<Orderr, Long> id_ord;
	public static volatile SingularAttribute<Orderr, Supplier> supplier;
	public static volatile SingularAttribute<Orderr, Date> signDate;
	public static volatile SingularAttribute<Orderr, Integer> totalCost;
	public static volatile SingularAttribute<Orderr, String> isCompleted;

}

