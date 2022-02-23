<?php declare(strict_types=1);

namespace Confware\Business\Statistic;

class Statistic implements \JsonSerializable
{
    public function __construct(
        public readonly int $participantsOnStation,
        public readonly int $participants,
        public readonly int $interactions,
        public readonly int $winners,
        public readonly int $participantsInWinningZone,
    )
    {}

    public function jsonSerialize() : array
    {
        return get_object_vars($this);
    }

    public static function random() : self {
        return new self(
            rand(1, 1000),
            rand(1, 1000),
            rand(1, 1000),
            rand(1, 1000),
            rand(1, 1000),
        );
    }
}