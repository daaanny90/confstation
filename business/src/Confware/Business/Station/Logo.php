<?php declare(strict_types=1);

namespace Confware\Business\Station;

class Logo implements \JsonSerializable
{
    public function __construct(
        public readonly string $src,
        public readonly string $title,
    )
    {}

    public function jsonSerialize() : array
    {
        return get_object_vars($this);
    }
}