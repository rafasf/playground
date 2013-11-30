var should = require('should');
var _ = require('underscore');
var composer = require('../lyrics');

describe('Lyrics', function () {

  it('creates a segment for the given number of bottles', function () {
    composer.lyricSegment(2).should.eql([
      '2 bottles of beer on the wall',
      '2 bottles of beer',
      'Take one down, pass it around',
      '1 bottle of beer on the wall']);
  });

  it('has a different ending if it\'s the last bottle', function () {
    _.last(composer.lyricSegment(1)).should.eql('No more bottles of beer on the wall');
  });

  it('creates a song with the given size and lyric creator', function () {
    composer.songWith(99, 0, composer.lyricSegment).length.should.eql(99 * 4);
  });

});

