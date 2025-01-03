package profid.core.service;

public interface EntityConverter<T extends JpaEntity, K>{
    K convert(T entity);
}
