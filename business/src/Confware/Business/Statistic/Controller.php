<?php declare(strict_types=1);

namespace Confware\Business\Statistic;

use Confware\Business\Response;
use Psr\Http\Message\ResponseInterface;
use Psr\Http\Message\ServerRequestInterface;

class Controller
{
    public function __invoke(ServerRequestInterface $request, ResponseInterface $response, array $args = []) : ResponseInterface
    {
        return Response::json($response, Statistic::random());
    }
}