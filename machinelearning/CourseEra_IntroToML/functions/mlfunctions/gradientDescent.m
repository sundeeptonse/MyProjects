function [theta, J_history] = gradientDescent(X, y, theta, alpha, num_iters)
	% ============================================================
	%	GRADIENTDESCENT Performs gradient descent to learn theta
	%   theta = GRADIENTDESCENT(X, y, theta, alpha, num_iters) updates theta by
	%   taking num_iters gradient steps with learning rate alpha

	%   theta is (n+1)*1 vector,
	%   X is m*(n+1),
	%   y is  m*1 vector
	%   n is the number of features,m is number of samples
	%  ============================================================

	m = length(y); % number of training examples
	J_history = zeros(num_iters, 1);

	for iter = 1:num_iters

		% ============================================================
		% if we calculate one by one, we transpose to get sum
		% X(0,:) -> m*1
		% delta0 = 1/m*X(0, :)'*error; -> 1*1
		% delta1 = 1/m*X(1, :)'*error;

		% To Calculate at one go
		% delta vector will be size n+1*1, i.e number of features
		% X' will be n+1 * m , error is m*1, which gives us n+1*1
		% Multiplication will give the sum of the values
		% ============================================================

		delta = 1/m*X' * errorFunction(X, y , theta);
		theta = theta - alpha*delta;

		% Save the cost J in every iteration
		J_history(iter) = computeCost(X, y, theta);

	end
	% =========================================================================

end
