function [theta] = normalEqn(X, y)
	% ============================================================
	%	NORMALEQN Computes the closed-form solution to linear regression
	%   NORMALEQN(X,y) computes the closed-form solution to linear
	%   regression using the normal equations.
	% Time complexity is O(n^3)
	% ============================================================
	theta = pinv(X'*X)*X'*y
	% ============================================================
end
