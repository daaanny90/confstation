<?php declare(strict_types=1);

namespace Confware\Business\Station;

class Station implements \JsonSerializable
{
    public function __construct(
        public readonly string $uuid,
        public readonly string $name,
        public readonly Event $event,
        public readonly Logo $logo,
        public readonly Theme $theme
    )
    {}

    public function jsonSerialize() : array
    {
        return get_object_vars($this);
    }

    public static function createFromId(?int $id) : ?self {
        if (null === $id) {
            return null;
        }
        return new self(
            (string) $id,
            "Station-$id",
            Event::createFromId($id),
            new Logo("https://b2ms.de/wp-content/uploads/2019/08/logo.png", "title-$id"),
            new Theme("div {color:red; background-color:blue}")
        );
    }
}