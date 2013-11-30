var _ = require('underscore');

var lyricSegment = function(n) {
  return _.chain([])
    .push(n + ' bottles of beer on the wall')
    .push(n + ' bottles of beer')
    .push('Take one down, pass it around')
    .tap(function(lyric) {
      if (n > 1) lyric.push((n - 1) + ' bottle of beer on the wall')
      else lyric.push('No more bottles of beer on the wall')
    }).value();
}

var songWith = function(start, end, lyricGen) {
  return _.reduce(_.range(start, end, -1),
                  function(song, n) { return song.concat(lyricGen(n)) },
                  []);
}

exports.lyricSegment = lyricSegment;
exports.songWith = songWith;
