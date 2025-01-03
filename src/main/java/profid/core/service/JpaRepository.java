package profid.core.service;

import java.util.UUID;

public interface JpaRepository<T extends JpaEntity>
        extends org.springframework.data.jpa.repository.JpaRepository<T, UUID> {
}
