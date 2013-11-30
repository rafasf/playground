var should = require('should');
var p = require('../partial');

describe('partial', function () {

  it('calls the function with the arguments', function () {
    var div = function(x, y) { return x / y; };
    var over10 = p.partial1(div, 10);

    over10(5).should.be.eql(2);
  });

});
