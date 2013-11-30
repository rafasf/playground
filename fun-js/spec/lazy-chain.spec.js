var should = require('should');
var l = require('../lazy-chain');

describe('lazy chain', function () {
  var lazyChain;

  beforeEach(function () {
    lazyChain = l.lazyChain([2, 1, 3]);
  });

  it('executes given call when force is called', function () {
    lazyChain.invoke('sort').force().should.be.eql([1, 2, 3]);
  });

  it('executes all the calls when force is called', function () {
    lazyChain
      .invoke('concat', [8, 5, 7, 6])
      .invoke('sort')
      .invoke('join', ' ')
      .force().should.be.eql('1 2 3 5 6 7 8');
  });

});
