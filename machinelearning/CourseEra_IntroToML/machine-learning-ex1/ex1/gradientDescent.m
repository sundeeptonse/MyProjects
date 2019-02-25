function [theta, J_history] = gradientDescent(X, y, theta, alpha, num_iters)
%GRADIENTDESCENT Performs gradient descent to learn theta
%   theta = GRADIENTDESCENT(X, y, theta, alpha, num_iters) updates theta by 
%   taking num_iters gradient steps with learning rate alpha

% Initialize some useful values
m = length(y); % number of training examples
J_history = zeros(num_iters, 1);

for iter = 1:num_iters

    % ====================== YOUR CODE HERE ======================
    % Instructions: Perform a single gradient step on the parameter vector
    %               theta. 
    %
    % Hint: While debugging, it can be useful to print out the values
    %       of the cost function (computeCost) and gradient here.
    %
    
    % X -> (m*n+1), theta -> n+1*1, y -> m*1
    % error -> m*1 
    % X(i, :) -> m*1,  ith value of all m values , i.e first value/second value etc
    
    prediction = X*theta;
    error = prediction - y;
    
    % if we calculate one by one, we transpose to get sum - refer final formula
    % X(0,:) -> m*1 
    % delta0 = 1/m*X(0, :)'*error; -> 1*1
    % delta1 = 1/m*X(1, :)'*error; 

    % To Calculate at one go
    % delta vector will be size n+1, i.e number of features --> X' will be n+1 * m , error is m*1, which gives us n+1*1
    % This will mutliply and sum up the values

    delta = 1/m*X'*error; 
    % Re-calculate theta
    theta = theta - alpha*delta;



    % ============================================================
    % size(X)
    % size(y)
    % size(theta)

    % Save the cost J in every iteration    
    J_history(iter) = computeCost(X, y, theta);

end

end
