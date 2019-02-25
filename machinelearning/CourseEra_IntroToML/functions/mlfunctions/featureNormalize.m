function [X_norm, mu, sigma] = featureNormalize(X)
	% ============================================================
	%	FEATURENORMALIZE Normalizes the features in X
	%   FEATURENORMALIZE(X) returns a normalized version of X where
	%   the mean value of each feature is 0 and the standard deviation
	%   is 1. This is often a good pre-processing step to do when
	%   working with learning algorithms.

	% 	Here X is the m*n matrix not m*n+1
	%	mu -> mean should be the mean of all the features, hence size 1*n
	%	sigma -> should be the standard deviation of the features, hence size should be 1*n
	% ============================================================

	X_norm = X;
	mu = mean(X);
	%sigma = max(X) - min(X);
	sigma = std(X);
	X_norm = (X_norm - mu) ./ sigma;
	% ============================================================

end
