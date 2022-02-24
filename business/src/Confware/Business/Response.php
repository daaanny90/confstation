<?php declare(strict_types=1);

namespace Confware\Business;
header('Access-Control-Allow-Origin: *');

use Psr\Http\Message\ResponseInterface;

class Response
{
    public static function jsonOrNotFound(ResponseInterface $response, $data) : ResponseInterface {
        return $data ? self::json($response, $data) : self::notFound($response, 'Not Found');
    }

    public static function json(ResponseInterface $response, $data) : ResponseInterface {
        $response->getBody()->write(json_encode($data));
        return $response->withStatus(200)->withHeader("Content-Type", "application/json");
    }

    public static function notFound(ResponseInterface $response, string $msg) : ResponseInterface {
        $response->getBody()->write(json_encode($msg));
        return $response->withStatus(404)->withHeader("Content-Type", "application/json");
    }
}