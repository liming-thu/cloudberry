#!/usr/bin/env bash
sbt "project noah" "run-main edu.uci.ics.cloudberry.noah.feed.TwitterFeedStreamDriver \
-ck gj66YYGOqTsmPKfTnvrVVGg0p \
-cs ZX1eiXNJisErOK8EW9l14VQK8RNM1TmX8SY5DwVrIOdrjDO8U4 \
-tk 227724989-U0Ou7nN4Gr4Z4fwZnoSEi5UQjlFJyZWNK1X09qtY \
-ts Fd6rl5jKEACB2HgQh5je0ZbNl2y3UslHQ8FuWHE6eJ95U \
-loc -173.847656,17.644022,-65.390625,70.377854 \
-u 127.0.0.1 -p 10001 -w 0 -b 50"
