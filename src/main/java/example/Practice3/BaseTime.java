package example.Practice3;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter // 자식클래스들이 호출 할 수 있도록
@NoArgsConstructor
@MappedSuperclass // 상속용도의 매핑 클래스 지정
@EntityListeners (AuditingEntityListener.class) // JPA Auditing 구현
public class BaseTime {
    @CreatedDate
    private LocalDateTime createDate; // 등록날짜
    @LastModifiedBy
    private LocalDateTime updateDate; // 수정날짜
}
// 로그( 모든 이벤트/행위 ) 관례적으로 남긴다. // 개인정보 5년