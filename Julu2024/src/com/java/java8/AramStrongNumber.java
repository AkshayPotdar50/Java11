package com.java.java8;

public class AramStrongNumber {
    public static boolean isAramstrong(int num){
        String numberStr=String.valueOf(num);
        int numberOfDigit=numberStr.length();

        int sum=numberStr.chars()
                .map(Character::getNumericValue)
                .map(digit->(int)Math.pow(digit, numberOfDigit))
                .sum();
        return sum == num;
    }

    public static boolean isAramstrong2(int num){
        String numberStr=String.valueOf(num);
        int numberOfDigit=numberStr.length();
        int sum=numberStr.chars().map(Character::getNumericValue)
                .map(digit->(int)Math.pow(digit, numberOfDigit)).sum();
        return  sum == num;
    }

    public static void main(String[] args) {
        int number=152;
        System.out.println(isAramstrong(number));
        System.out.println("********************************************");
        System.out.println(isAramstrong2(number));
    }



    /*
    *
    *
    * @Service
public class PaymentService {

    @Autowired
    private PaymentTransactionRepository paymentTransactionRepository;

    @Autowired
    private PaymentGatewayClient paymentGatewayClient; // Handles communication with the payment gateway

    public PaymentResponse initiatePayment(Long orderId, Double amount, String currency) {
        // Create a new payment transaction record
        PaymentTransaction transaction = new PaymentTransaction();
        transaction.setOrderId(orderId);
        transaction.setAmount(amount);
        transaction.setCurrency(currency);
        transaction.setStatus("PENDING");
        transaction.setCreatedAt(LocalDateTime.now());

        paymentTransactionRepository.save(transaction);

        // Call payment gateway to initiate transaction
        PaymentRequest paymentRequest = new PaymentRequest(orderId, amount, currency);
        PaymentGatewayResponse response = paymentGatewayClient.initiatePayment(paymentRequest);

        // Update transaction with gateway response
        transaction.setTransactionId(response.getTransactionId());
        paymentTransactionRepository.save(transaction);

        return new PaymentResponse(response.getPaymentUrl(), transaction.getTransactionId());
    }

    public void updatePaymentStatus(String transactionId, String status) {
        // Update payment status based on webhook or polling
        PaymentTransaction transaction = paymentTransactionRepository.findByTransactionId(transactionId)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));

        transaction.setStatus(status);
        transaction.setUpdatedAt(LocalDateTime.now());
        paymentTransactionRepository.save(transaction);
    }
}
*
*
*
*
*
* @Component
public class PaymentGatewayClient {

    public PaymentGatewayResponse initiatePayment(PaymentRequest paymentRequest) {
        // Call the payment gateway API
        // Use RestTemplate, WebClient, or a third-party SDK
        // Example pseudo-code:
        String url = "https://payment-gateway.com/api/payments";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<PaymentGatewayResponse> response = restTemplate.postForEntity(url, paymentRequest, PaymentGatewayResponse.class);

        return response.getBody();
    }
}

*
*
*
*
* 
*/
}
