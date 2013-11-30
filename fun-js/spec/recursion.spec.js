var should = require('should');
var _ = require('underscore');
var r = require('../recursion');

describe('myLength', function () {
  it('returns the number the elements of an array', function () {
    r.myLength([1, 2, 4]).should.be.eql(3);
  });
});

describe('cycle', function () {
  it('repeats a number of times the elements of an array', function () {
    r.cycle(2, [1, 2, 4]).should.be.eql([1, 2, 4, 1, 2, 4]);
  });
});

describe('unzipping', function () {

  it('creates a pair from an array with two elements', function () {
    r.constructPair(['a', '1'], [ [], [] ]).should.be.eql([['a'], ['1']]);
  });

  it('unzips given array', function () {
    r.unzip([ ['a', 1],  ['b', 2], ['c', 3] ]).should.be.eql([['a', 'b', 'c'], [1, 2, 3]]);
  });

});

describe('influences', function () {
    var influences = [
      ['Lisp', 'Smalltalk'],
      ['Lisp', 'Scheme'],
      ['Smalltalk', 'Self'],
      ['Scheme', 'JavaScript'],
      ['Scheme', 'Lua'],
      ['Self', 'Lua'],
      ['Self', 'JavaScript']];

  it('shows the influenced items for a given one', function () {
    r.nexts(influences, 'Lisp').should.be.eql(['Smalltalk', 'Scheme']);
  });

  it('shows items that it were seem through the search', function () {
    r.depthSearch(influences, ['Lisp'], []).should.be.eql(['Scheme', 'JavaScript', 'Lua', 'Self', 'Smalltalk', 'Lisp']);
  });

  it('shows the influenced items of an item', function () {
    r.influenced(influences, 'Lisp').should.be.eql(['Smalltalk', 'Scheme']);
  });

});

describe('andify', function () {
  var isEven = function(n) { return n % 2 === 0; };
  var evenNums = r.andify(_.isNumber, isEven);

  it('returns true if all arguments meet the conditions', function () {
    evenNums(2, 4, 6).should.be.true;
  });

  it('returns false if any of the arguments does not meet the conditions', function () {
    evenNums(1, 2, 4).should.be.false;
  });
});

describe('orify', function () {
  var zero = function(n) { return n === 0; };
  var isOdd = function(n) { return n % 2 !== 0; };
  var zeroOrOdd = r.orify(zero, isOdd);

  it('returns true if at least one of the arguments meet one of the conditions', function () {
    zeroOrOdd(0, 2, 4, 5).should.be.true;
  });

  it('returns false if none of the arguments meet any of the conditions',  function () {
    zeroOrOdd(2, 4, 6).should.be.false;
  });
});
