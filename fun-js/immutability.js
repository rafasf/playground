var _ = require('underscore');
var b = require('./basic');

var merge = function () {
  return _.extend.apply(null, b.construct({}, arguments));
};

exports.merge = merge;
