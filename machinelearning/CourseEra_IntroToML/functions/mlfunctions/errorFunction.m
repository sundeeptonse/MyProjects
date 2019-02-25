function error = error(X, y ,theta)

% error -> Computes the error for a linear regression
% error = hypothesis - y
% theta is (n+1)*1 vector,
% X is m*(n+1),
% y is  m*1 vector
% n is the number of features,m is number of samples
% =========================================================================
error = hypothesis(X, theta) - y;
% =========================================================================
end
