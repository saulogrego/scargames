-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.5.21


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema scargames
--

CREATE DATABASE IF NOT EXISTS scargames;
USE scargames;

--
-- Definition of table `bandeira`
--

DROP TABLE IF EXISTS `bandeira`;
CREATE TABLE `bandeira` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `descricao` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bandeira`
--

/*!40000 ALTER TABLE `bandeira` DISABLE KEYS */;
/*!40000 ALTER TABLE `bandeira` ENABLE KEYS */;

--
-- Definition of table `cidade`
--

DROP TABLE IF EXISTS `cidade`;
CREATE TABLE `cidade` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `estado` varchar(2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cidade`
--

/*!40000 ALTER TABLE `cidade` DISABLE KEYS */;
/*!40000 ALTER TABLE `cidade` ENABLE KEYS */;


--
-- Definition of table `genero`
--

DROP TABLE IF EXISTS `genero`;
CREATE TABLE `genero` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `descricao` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `genero`
--

/*!40000 ALTER TABLE `genero` DISABLE KEYS */;
/*!40000 ALTER TABLE `genero` ENABLE KEYS */;

--
-- Definition of table `produtora`
--

DROP TABLE IF EXISTS `produtora`;
CREATE TABLE `produtora` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `produtora`
--

/*!40000 ALTER TABLE `produtora` DISABLE KEYS */;
/*!40000 ALTER TABLE `produtora` ENABLE KEYS */;

--
-- Definition of table `jogo`
--

DROP TABLE IF EXISTS `jogo`;
CREATE TABLE `jogo` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `titulo` varchar(100) NOT NULL,
  `classificacao` int(10) unsigned NOT NULL,
  `sinopse` varchar(1000) NOT NULL,
  `requisitos` varchar(200) NOT NULL,
  `nota` double NOT NULL,
  `genero` int(10) unsigned NOT NULL,
  `produtora` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `genero_jogo_id` FOREIGN KEY (`id`) REFERENCES `genero` (`id`),
  CONSTRAINT `produtora_jogo_id` FOREIGN KEY (`id`) REFERENCES `produtora` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jogo`
--

/*!40000 ALTER TABLE `jogo` DISABLE KEYS */;
/*!40000 ALTER TABLE `jogo` ENABLE KEYS */;

--
-- Definition of table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE `usuario` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `cpf` varchar(11) NOT NULL,
  `dataNascimento` date NOT NULL,
  `sexo` char(1) NOT NULL,
  `telefone` varchar(45) NOT NULL,
  `email` varchar(50) NOT NULL,
  `senha` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `usuario`
--

/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;


--
-- Definition of table `endereco`
--

DROP TABLE IF EXISTS `endereco`;
CREATE TABLE `endereco` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `logradouro` varchar(100) NOT NULL,
  `numero` varchar(20) NOT NULL,
  `complemento` varchar(30) DEFAULT NULL,
  `bairro` varchar(100) NOT NULL,
  `cep` varchar(10) NOT NULL,
  `cidade` int(10) unsigned NOT NULL,
  `usuario` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `cidade_endereco_id` FOREIGN KEY (`id`) REFERENCES `cidade` (`id`),
  CONSTRAINT `usuario_endereco_id` FOREIGN KEY (`id`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `endereco`
--

/*!40000 ALTER TABLE `endereco` DISABLE KEYS */;
/*!40000 ALTER TABLE `endereco` ENABLE KEYS */;


--
-- Definition of table `cartao`
--

DROP TABLE IF EXISTS `cartao`;
CREATE TABLE `cartao` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `numero` varchar(15) NOT NULL,
  `vencimento` date NOT NULL,
  `bandeira` int(10) unsigned NOT NULL,
  `usuario` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `bandeira_cartao_id` FOREIGN KEY (`id`) REFERENCES `bandeira` (`id`),
  CONSTRAINT `usuario_cartao_id` FOREIGN KEY (`id`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cartao`
--

/*!40000 ALTER TABLE `cartao` DISABLE KEYS */;
/*!40000 ALTER TABLE `cartao` ENABLE KEYS */;


--
-- Definition of table `biblioteca`
--

DROP TABLE IF EXISTS `biblioteca`;
CREATE TABLE `biblioteca` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `usuario` int(10) unsigned NOT NULL,
  `jogo` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `jogo_biblioteca_id` FOREIGN KEY (`id`) REFERENCES `jogo` (`id`),
  CONSTRAINT `usuario_biblioteca_id` FOREIGN KEY (`id`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `biblioteca`
--

/*!40000 ALTER TABLE `biblioteca` DISABLE KEYS */;
/*!40000 ALTER TABLE `biblioteca` ENABLE KEYS */;



/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
