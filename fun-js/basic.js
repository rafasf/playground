var _ = require('underscore');

var existy = function(what) { return what != null; };
var truthy = function(what) { return (what !== false) && existy(what); };
var doWhen = function(condition, action) {
  if (truthy(condition)) {
    return action();
  } else { return undefined; }
};

var cat = function () {
  var head = _.first(arguments);
  if (head !== null) {
    return head.concat.apply(head, _.rest(arguments));
  } else { return []; }
};

var construct = function(head, tail) {
  return cat([head], _.toArray(tail));
};

var second = function(something) {
  return something[1];
};

exports.existy = existy;
exports.truthy = truthy;
exports.doWhen = doWhen;
exports.cat = cat;
exports.construct = construct;
exports.second = second;
