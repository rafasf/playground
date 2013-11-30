var _ = require('underscore');
var b = require('./basic');
var f = require('./fun-return-fun');

var myLength = function(arr) {
  if (_.isEmpty(arr)) return 0;
  return 1 + myLength(_.rest(arr));
};

var cycle = function(times, arr) {
  if (times <= 0) return [];
  return b.cat(arr, cycle(times - 1, arr));
};

var constructPair = function(pair, rest) {
  return [b.construct(_.first(pair), _.first(rest)),
          b.construct(_.first(_.rest(pair)), _.first(_.rest(rest)))];
};

var unzip = function(pairs) {
  if (_.isEmpty(pairs)) return [ [], [] ];
  return constructPair(_.first(pairs), unzip(_.rest(pairs)));
};

var nexts = function(graph, node) {
  if (_.isEmpty(graph)) return [];

  var pair = _.first(graph),
      from = _.first(pair),
      to   = _.first(_.rest(pair)),
      more = _.rest(graph);

  return (_.isEqual(node, from)) ? b.construct(to, nexts(more, node)) : nexts(more, node);
};

var depthSearch = function(graph, nodes, seen) {
  if (_.isEmpty(nodes)) return seen;

  var node = _.first(nodes),
      more = _.rest(nodes);

  if (_.contains(seen, node))
    return depthSearch(graph, more, seen);
  else
    return depthSearch(graph,
        b.cat(nexts(graph, node), more),
        b.construct(node, seen));
};

var andify = function () {
  var predicates = _.toArray(arguments);

  return function () {
    var args = _.toArray(arguments);

    var everything = function(ps, truth) {
      if (_.isEmpty(ps)) return truth;
      else return _.every(args, _.first(ps)) && everything(_.rest(ps), truth);
    };

    return everything(predicates, true);
  };
};

var orify = function () {
  var predicates = _.toArray(arguments);

  return function () {
    var args = _.toArray(arguments);

    var something = function(ps, truth) {
      if (_.isEmpty(ps)) return truth;
      else return _.some(args, _.first(ps)) || something(_.rest(ps), truth);
    };

    return something(predicates, false);
  };
};

var groupFrom = f.curry2(_.groupBy)(_.first);

var influenced = function(graph, node) {
  return _.map(groupFrom(graph)[node], b.second);
};

exports.myLength = myLength;
exports.cycle = cycle;
exports.constructPair = constructPair;
exports.unzip = unzip;
exports.nexts = nexts;
exports.depthSearch = depthSearch;
exports.andify = andify;
exports.orify = orify;
exports.influenced = influenced;
