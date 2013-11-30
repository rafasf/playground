var _ = require('underscore');
var b = require('./basic');

var invoker = function(name, method) {
  return function(target) {
    if (!b.existy(target)) throw 'no target';

    var targetMethod = target[name];
    var args = _.rest(arguments);

    return b.doWhen(existy(targetMethod) && method === targetMethod, function () {
      return targetMethod.apply(target, args);
    });
  };
};

var fnull = function(fun) {
  var defaults = _.rest(arguments);

  return function () {
    var args = _.map(arguments, function(elem, index) {
      return b.existy(elem) ? elem : defaults[index];
    });

    return fun.apply(null, args);
  };
};

var defaults = function(d) {
  return function(o, k) {
    var val = fnull(_.identity, d[k]);
    return o && val(o[k]);
  };
};

var doSomething = function(config) {
  var lookup = defaults({critical: 108});
  return lookup(config, 'critical');
};

var checker = function () {
  var validators = _.toArray(arguments);

  return function(obj) {
    return _.reduce(validators, function(errors, check) {
      if (check(obj)) return errors;
      else _.chain(errors).push(check.message).value();
    }, []);
  };
};

var leftCurryDiv = function(n) { return function(d) { return n/d; } };
var rightCurryDiv = function(d) { return function(n) { return n/d; } };

var curry = function(fun) { return function(arg) { return fun(arg); } };
var curry2 = function(fun) {
  return function(secondArg) {
    return function(firstArg) {
      return fun(firstArg, secondArg);
    };
  };
};

exports.invoker = invoker;
exports.fnull = fnull;
exports.defaults = defaults;
exports.doSomething = doSomething;
exports.checker = checker;
exports.leftCurryDiv = leftCurryDiv;
exports.rightCurryDiv = rightCurryDiv;
exports.curry = curry;
exports.curry2 = curry2;
