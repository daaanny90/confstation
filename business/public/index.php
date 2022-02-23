<?php declare(strict_types=1);

use Confware\Business\Station\Controller as StationController;
use Confware\Business\Statistic\Controller as StatisticController;
use Slim\Factory\AppFactory;

require implode(DIRECTORY_SEPARATOR, [__DIR__, '..', 'vendor', 'autoload.php']);

$app = AppFactory::create();

$app->get('/station/{stationId}', new StationController());
$app->get('/statistic', new StatisticController());

$app->addErrorMiddleware(true, true, true);

$app->run();