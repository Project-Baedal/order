//gpackage com.baedal.order.application.port.out;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.jupiter.api.Assertions.*;
//
//import com.baedal.order.adapter.out.persistence.repository.OrderRedisRepository;
//import com.baedal.order.domain.model.AddOrderValidate;
//import com.baedal.order.domain.model.ValidateResult;
//import com.baedal.order.global.test.IntegrationTest;
//import java.util.Objects;
//import java.util.Set;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//
//class OrderCacheRepositoryPortTest extends IntegrationTest {
//
//  @Autowired
//  private OrderCacheRepositoryPort orderCacheRepositoryPort;
//
//  @Test
//  void get() {
//    Set<ValidateResult> a = orderCacheRepositoryPort.getOrderValidationStatus("82a7223b-7ca1-45b4-95e7-eb2949aee880");
//    System.out.println("갯수" + a.size());
//  }
//
//
//  @Test
//  void getOrderValidationStatus() {
//    AddOrderValidate req = AddOrderValidate.builder()
//        .orderTransactionId("id")
//        .domain("domain")
//        .status(true)
//        .build();
//    orderCacheRepositoryPort.addOrderValidate(req);
//
//    Set<ValidateResult> set = orderCacheRepositoryPort.getOrderValidationStatus("id");
//    assertThat(set.size()).isEqualTo(1);
//  }
//}