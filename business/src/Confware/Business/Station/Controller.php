<?php declare(strict_types=1);

namespace Confware\Business\Station;

use BZRK\PHPStream\Streams;
use Confware\Business\Response;
use Psr\Http\Message\ResponseInterface;
use Psr\Http\Message\ServerRequestInterface;

class Controller
{
    public function __invoke(ServerRequestInterface $request, ResponseInterface $response, array $args = []) : ResponseInterface
    {
        $stationId = $args['stationId'] ?? null;

        $data = Streams::range(1000, 1100)
            ->filter(fn(int $it) => $stationId == $it)
            ->map(fn(?int $it) => Station::createFromId($it))
            ->first();

        return Response::jsonOrNotFound($response, $data);
    }
}