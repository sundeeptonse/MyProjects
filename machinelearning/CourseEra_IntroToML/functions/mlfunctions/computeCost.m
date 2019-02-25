function J = computeCost(X, y, theta)

	% =========================================================================
	%   COMPUTECOST Compute cost for linear regression
	%   J = COMPUTECOST(X, y, theta) computes the cost of using theta as the
	%   parameter for linear regression to fit the data points in X and y

	% theta is (n+1)*1 vector,
	% X is m*(n+1),
	% y is  m*1 vector
	% n is the number of features,m is number of samples
	% =========================================================================
	m = length(y); % number of training examples
	J = 1/(2*m) * sum((errorFunction(X, y, theta)).^2);
	% =========================================================================
end
