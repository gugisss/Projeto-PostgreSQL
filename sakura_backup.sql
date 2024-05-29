--
-- PostgreSQL database dump
--

-- Dumped from database version 16.3
-- Dumped by pg_dump version 16.3

-- Started on 2024-05-29 02:44:23

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 222 (class 1259 OID 16420)
-- Name: clientes; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.clientes (
    id integer NOT NULL,
    nome character varying(100) NOT NULL,
    email character varying(50)
);


ALTER TABLE public.clientes OWNER TO postgres;

--
-- TOC entry 221 (class 1259 OID 16419)
-- Name: clientes_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.clientes_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.clientes_id_seq OWNER TO postgres;

--
-- TOC entry 4838 (class 0 OID 0)
-- Dependencies: 221
-- Name: clientes_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.clientes_id_seq OWNED BY public.clientes.id;


--
-- TOC entry 220 (class 1259 OID 16413)
-- Name: garcons; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.garcons (
    id integer NOT NULL,
    usuario character varying(50) NOT NULL,
    senha character varying(50) NOT NULL
);


ALTER TABLE public.garcons OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 16412)
-- Name: garcons_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.garcons_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.garcons_id_seq OWNER TO postgres;

--
-- TOC entry 4839 (class 0 OID 0)
-- Dependencies: 219
-- Name: garcons_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.garcons_id_seq OWNED BY public.garcons.id;


--
-- TOC entry 218 (class 1259 OID 16406)
-- Name: gerentes; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.gerentes (
    id integer NOT NULL,
    usuario character varying(50) NOT NULL,
    senha character varying(50) NOT NULL
);


ALTER TABLE public.gerentes OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 16405)
-- Name: gerentes_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.gerentes_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.gerentes_id_seq OWNER TO postgres;

--
-- TOC entry 4840 (class 0 OID 0)
-- Dependencies: 217
-- Name: gerentes_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.gerentes_id_seq OWNED BY public.gerentes.id;


--
-- TOC entry 226 (class 1259 OID 16434)
-- Name: pedidos; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pedidos (
    id integer NOT NULL,
    descricao text NOT NULL,
    cliente_id integer NOT NULL
);


ALTER TABLE public.pedidos OWNER TO postgres;

--
-- TOC entry 225 (class 1259 OID 16433)
-- Name: pedidos_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.pedidos_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.pedidos_id_seq OWNER TO postgres;

--
-- TOC entry 4841 (class 0 OID 0)
-- Dependencies: 225
-- Name: pedidos_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.pedidos_id_seq OWNED BY public.pedidos.id;


--
-- TOC entry 224 (class 1259 OID 16427)
-- Name: pratos; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pratos (
    id integer NOT NULL,
    nome character varying(100) NOT NULL,
    preco numeric(10,2) NOT NULL
);


ALTER TABLE public.pratos OWNER TO postgres;

--
-- TOC entry 223 (class 1259 OID 16426)
-- Name: pratos_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.pratos_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.pratos_id_seq OWNER TO postgres;

--
-- TOC entry 4842 (class 0 OID 0)
-- Dependencies: 223
-- Name: pratos_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.pratos_id_seq OWNED BY public.pratos.id;


--
-- TOC entry 216 (class 1259 OID 16399)
-- Name: socios; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.socios (
    id integer NOT NULL,
    usuario character varying(50) NOT NULL,
    senha character varying(50) NOT NULL
);


ALTER TABLE public.socios OWNER TO postgres;

--
-- TOC entry 215 (class 1259 OID 16398)
-- Name: socios_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.socios_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.socios_id_seq OWNER TO postgres;

--
-- TOC entry 4843 (class 0 OID 0)
-- Dependencies: 215
-- Name: socios_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.socios_id_seq OWNED BY public.socios.id;


--
-- TOC entry 4662 (class 2604 OID 16423)
-- Name: clientes id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.clientes ALTER COLUMN id SET DEFAULT nextval('public.clientes_id_seq'::regclass);


--
-- TOC entry 4661 (class 2604 OID 16416)
-- Name: garcons id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.garcons ALTER COLUMN id SET DEFAULT nextval('public.garcons_id_seq'::regclass);


--
-- TOC entry 4660 (class 2604 OID 16409)
-- Name: gerentes id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.gerentes ALTER COLUMN id SET DEFAULT nextval('public.gerentes_id_seq'::regclass);


--
-- TOC entry 4664 (class 2604 OID 16437)
-- Name: pedidos id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pedidos ALTER COLUMN id SET DEFAULT nextval('public.pedidos_id_seq'::regclass);


--
-- TOC entry 4663 (class 2604 OID 16430)
-- Name: pratos id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pratos ALTER COLUMN id SET DEFAULT nextval('public.pratos_id_seq'::regclass);


--
-- TOC entry 4659 (class 2604 OID 16402)
-- Name: socios id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.socios ALTER COLUMN id SET DEFAULT nextval('public.socios_id_seq'::regclass);


--
-- TOC entry 4828 (class 0 OID 16420)
-- Dependencies: 222
-- Data for Name: clientes; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.clientes (id, nome, email) FROM stdin;
1	lucas	\N
2	lucas	\N
35	gustavo	gugufm2015@gmail.com
36	gugugug	gugugu
\.


--
-- TOC entry 4826 (class 0 OID 16413)
-- Dependencies: 220
-- Data for Name: garcons; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.garcons (id, usuario, senha) FROM stdin;
2	garcom2	senha123
1	garçom5	senha123
\.


--
-- TOC entry 4824 (class 0 OID 16406)
-- Dependencies: 218
-- Data for Name: gerentes; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.gerentes (id, usuario, senha) FROM stdin;
1	gerente1	senha1
2	gerente2	senha123
3	gerente3	senha123
4	joaozinho	senha123
\.


--
-- TOC entry 4832 (class 0 OID 16434)
-- Dependencies: 226
-- Data for Name: pedidos; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.pedidos (id, descricao, cliente_id) FROM stdin;
2	1. macarrao 3 cocas zero	1
\.


--
-- TOC entry 4830 (class 0 OID 16427)
-- Dependencies: 224
-- Data for Name: pratos; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.pratos (id, nome, preco) FROM stdin;
1	macarrao	100.00
2	macarrao a bolonhesa	24.00
\.


--
-- TOC entry 4822 (class 0 OID 16399)
-- Dependencies: 216
-- Data for Name: socios; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.socios (id, usuario, senha) FROM stdin;
1	socio1	senha123
\.


--
-- TOC entry 4844 (class 0 OID 0)
-- Dependencies: 221
-- Name: clientes_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.clientes_id_seq', 36, true);


--
-- TOC entry 4845 (class 0 OID 0)
-- Dependencies: 219
-- Name: garcons_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.garcons_id_seq', 2, true);


--
-- TOC entry 4846 (class 0 OID 0)
-- Dependencies: 217
-- Name: gerentes_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.gerentes_id_seq', 4, true);


--
-- TOC entry 4847 (class 0 OID 0)
-- Dependencies: 225
-- Name: pedidos_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.pedidos_id_seq', 2, true);


--
-- TOC entry 4848 (class 0 OID 0)
-- Dependencies: 223
-- Name: pratos_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.pratos_id_seq', 34, true);


--
-- TOC entry 4849 (class 0 OID 0)
-- Dependencies: 215
-- Name: socios_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.socios_id_seq', 1, true);


--
-- TOC entry 4672 (class 2606 OID 16425)
-- Name: clientes clientes_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.clientes
    ADD CONSTRAINT clientes_pkey PRIMARY KEY (id);


--
-- TOC entry 4670 (class 2606 OID 16418)
-- Name: garcons garcons_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.garcons
    ADD CONSTRAINT garcons_pkey PRIMARY KEY (id);


--
-- TOC entry 4668 (class 2606 OID 16411)
-- Name: gerentes gerentes_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.gerentes
    ADD CONSTRAINT gerentes_pkey PRIMARY KEY (id);


--
-- TOC entry 4676 (class 2606 OID 16441)
-- Name: pedidos pedidos_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pedidos
    ADD CONSTRAINT pedidos_pkey PRIMARY KEY (id);


--
-- TOC entry 4674 (class 2606 OID 16432)
-- Name: pratos pratos_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pratos
    ADD CONSTRAINT pratos_pkey PRIMARY KEY (id);


--
-- TOC entry 4666 (class 2606 OID 16404)
-- Name: socios socios_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.socios
    ADD CONSTRAINT socios_pkey PRIMARY KEY (id);


--
-- TOC entry 4677 (class 2606 OID 16442)
-- Name: pedidos pedidos_cliente_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pedidos
    ADD CONSTRAINT pedidos_cliente_id_fkey FOREIGN KEY (cliente_id) REFERENCES public.clientes(id) ON DELETE CASCADE;


-- Completed on 2024-05-29 02:44:24

--
-- PostgreSQL database dump complete
--

