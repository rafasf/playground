var should = require('should');
var b = require('../basic');

describe('existy', function () {

  describe('returns true', function () {
    it('if information is not null', function () {
      b.existy('real thing').should.be.true;
    });

    it('if information is present', function () {
      b.existy(false).should.be.true;
    });
  });


  describe('returns false', function () {
    it('if information is not present', function () {
      b.existy().should.be.false;
    });

    it('if information is null', function () {
      b.existy(null).should.be.false;
    });

    it('if information is undefined', function () {
      b.existy(undefined).should.be.false;
    });
  });

});

describe('truthy', function () {

  it('returns true if condition is present and true', function () {
    b.truthy(1 === 1).should.be.true;
  });

  describe('retruns false', function () {
    it('if condition is not present', function () {
      b.truthy().should.be.false;
    });

    it('if condition is not true', function () {
      b.truthy(1 === 2).should.be.false;
    });

    it('if condition is null', function () {
      b.truthy(null).should.be.false;
    });
  });

});

describe('doWhen', function () {
  var theAction = function () { return 1; };

  it('executes an action if condition is met', function () {
    b.doWhen(1 === 1, theAction).should.be.eql(1);
  });

  describe('returns undefined', function () {

    it('if condition is not met', function () {
      should.strictEqual(undefined, b.doWhen(1 === 2, theAction));
    });

    it('if condition is null', function () {
      should.strictEqual(b.doWhen(null, theAction));
    });
  });

});

describe('second', function () {
  it('returns the second element', function () {
    b.second(['1', '2']).should.be.eql('2');
  });
});
