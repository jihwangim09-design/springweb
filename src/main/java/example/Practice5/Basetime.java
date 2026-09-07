package example.Practice5;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter @NoArgsConstructor // 자식 클래스 호출 가능
@MappedSuperclass // 테이블이 아닌 상속용도
@EntityListeners ( AuditingEntityListener.class ) // 감시기능
public class Basetime {
    @CreatedDate private LocalDateTime createdAt;
    @LastModifiedDate private LocalDateTime updatedAt;
    
}
