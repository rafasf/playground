var _ = require('underscore');

var lazyChain = function(obj) {
  var self = {},
      calls = [];

  self.invoke = function(methodName) {
    var args = _.rest(arguments);

    calls.push(function(target) {
      var method = target[methodName];
      return method.apply(target, args);
    });

    return self;
  };

  self.force = function () {
    return _.reduce(calls, function(target, thunk) {
      return thunk(target);
    }, obj);
  };

  return self;
};

exports.lazyChain = lazyChain;
