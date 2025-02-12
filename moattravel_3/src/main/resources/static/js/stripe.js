const stripe = Stripe('pk_test_51QlmBA02q8VOKIndpoJRAk3xd7EObhn8IJM0yqvUqftAWdILOH488obTLsbWAc0RmWM1O4tHsUoLD4mKqkIIPWvJ009pE8FQwZ');
const paymentButton = document.querySelector('#paymentButton');
paymentButton.addEventListener('click', () => {
	atripe.redirectToCheckout({
		sessionId: sessionId
	})
});