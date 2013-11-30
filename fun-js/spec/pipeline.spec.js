var should = require('should');
var p = require('../pipeline');

describe('pipeline', function () {

  it('executes the computation in the given object', function () {
    p.pipeline(42, function(n) { return -n }).should.be.eql(-42);
  });

  it('executes all passed functions in the given object', function () {
    p.pipeline([2, 1, 3],
      function(o) { return o.concat([8, 5, 7, 6]); },
      function(o) { return o.sort(); },
      function(o) { return o.join(' '); }).should.be.eql('1 2 3 5 6 7 8');
  });

});
