<?php declare(strict_types=1);

namespace Confware\Business\Station;

class Event implements \JsonSerializable
{
    public function __construct(
        public readonly string $uuid,
        public readonly string $name,
        public readonly Logo $logo
    )
    {}

    public function jsonSerialize() : array
    {
        return get_object_vars($this);
    }

    public static function createFromId(?int $id) : self {
        return new self(
            "ev-$id",
            "Event-$id",
            new Logo("https://www.itsax.de/system/organisations/logos/194/facebook/logo.png20211027-17220-1jsetmo.jpg?1635365334", "ostec-$id")
        );
    }
}