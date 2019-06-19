function h = hypothesis(X, theta)

% =========================================================================
% hypothesis -> Computes the hypothesis for linear regression
% hypothesis -> X*theta,
% X is m*(n+1)
% theta is (n+1)*1 vector
% n is the number of features,m is number of samples

% or this could be X*theta tranpose, if theta is n+1 vector i.e 1 * (n+1)
% =========================================================================
h = X*theta;
% =========================================================================
end
