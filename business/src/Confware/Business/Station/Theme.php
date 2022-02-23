<?php declare(strict_types=1);

namespace Confware\Business\Station;

class Theme implements \JsonSerializable
{
    public function __construct(
        public readonly string $css,
    )
    {}

    public function jsonSerialize() : array
    {
        return get_object_vars($this);
    }
}