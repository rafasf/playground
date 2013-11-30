var should = require('should');
var r = require('../immutability');

describe('merge', function () {
  it('merges an object to the other without mutating the first', function () {
    var nameless = { age: 15 };
    var person = r.merge(nameless, { name: 'Bob' });

    nameless.should.be.eql({ age: 15 });
    person.should.be.eql({ age: 15, name: 'Bob' });
  });
});
