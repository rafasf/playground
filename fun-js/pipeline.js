var _ = require('underscore');

var pipeline = function(seed) {
  return _.reduce(_.rest(arguments),
      function(value, action) { return action(value); }, seed);
};

exports.pipeline = pipeline;
