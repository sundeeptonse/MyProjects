function J = computeCost(X, y, theta)
%COMPUTECOST Compute cost for linear regression
%   J = COMPUTECOST(X, y, theta) computes the cost of using theta as the
%   parameter for linear regression to fit the data points in X and y

% Initialize some useful values
m = length(y); % number of training examples
lengthX = size(X,2); %number of Features plus 1
lengthTheta = length(theta); 

% You need to return the following variables correctly 
J = 0;

% ====================== YOUR CODE HERE ======================
% Instructions: Compute the cost of a particular choice of theta
%               You should set J to the cost.

%theta is (n+1)*1 vector, X is m*(n+1), y is m*1 vector, where n is the number of features,m is number of samples
%Compare if theta length is valid

prediction= X*theta;
error = X*theta - y;

J = 1/(2*m) * sum((error).^2);



% =========================================================================

end
