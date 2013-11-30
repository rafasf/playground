var _ = require('underscore');
var b = require('./basic');

var partial1 = function(fun, firstArg) {
  return function () {
    var args = b.construct(firstArg, arguments);
    return fun.apply(fun, args);
  };
};

exports.partial1 = partial1;
