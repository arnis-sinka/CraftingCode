package com.arnis.payment;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class PaymentServiceShould {
	
	private UserValidator userValidator;
	private PaymentGateway paymentGateway;
	private PaymentService paymentService;
	private PaymentDetails paymentDetails;
	private User user;

	@BeforeEach
	private void initialize() {
		userValidator = mock(UserValidator.class);
		paymentGateway = mock(PaymentGateway.class);
		
		paymentDetails = new PaymentDetails();
		user = new User();
		paymentService = new PaymentService(userValidator, paymentGateway);
	}

	@Test
	public void notProcessPaymentWhenUserIsInvalid() {
		when(userValidator.isValid(user)).thenReturn(false);

		Executable e = () -> paymentService.processPayment(user, paymentDetails);
		
		assertThrows(IllegalArgumentException.class, e, "should fail");
		verify(paymentGateway, never()).pay(paymentDetails);
		verify(userValidator).isValid(user);
	}

	@Test
	public void processPaymentWhenUserIsValid() {
		when(userValidator.isValid(user)).thenReturn(true);
				
	    paymentService.processPayment(user, paymentDetails);
		
		verify(paymentGateway).pay(paymentDetails);
		verify(userValidator).isValid(user);
	}
}
