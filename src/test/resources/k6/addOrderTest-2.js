import http from "k6/http";
import { check } from "k6";

export const options = {
  stages: [
    { duration: "1m", target: 100 }
  ],
  thresholds: {
    http_req_duration: ["p(95)<1000"],
  },
};

export default function () {
  const orderData = {
    storeId: 123,
    productIds: [1, 2, 3],
    deliveryAddress: "서울시 강남구 테헤란로 123",
    phoneNumber: "010-1234-5678",
    paymentInfo: {
      method: "CARD",
      amount: 5000
    },
    deliveryAmount: 1000,
  };

  const response = http.post("http://localhost:8084/api/order/v0/", JSON.stringify(orderData), {
    headers: { "Content-Type": "application/json" },
  });

  check(response, {
    "success": (res) => res.status === 200,
  });
}
