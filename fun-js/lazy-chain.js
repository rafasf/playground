var _ = require('underscore');

var LazyChain = function(obj) {
  this._calls = [];
  this._target = obj;
};

LazyChain.prototype.invoke = function(methodName) {
  var args = _.rest(arguments);

  this._calls.push(function(target) {
    var method = target[methodName];
    return method.apply(target, args);
  });

  return this;
};

LazyChain.prototype.force = function () {
  return _.reduce(this._calls, function(target, thunk) {
    return thunk(target);
  }, this._target);
};

exports.LazyChain = LazyChain;
