CREATE TABLE IF NOT EXISTS public.calendar_meta
(
    calendar_date date NOT NULL,
    com_yr_wk integer NOT NULL,
    com_start_date date NOT NULL
)
INSERT INTO public.calendar_meta(calendar_date, com_yr_wk, com_start_date) VALUES ('2024-03-27', 12409, '2024-03-23');
INSERT INTO public.calendar_meta(calendar_date, com_yr_wk, com_start_date) VALUES ('2024-03-28', 12409, '2024-03-23');
INSERT INTO public.calendar_meta(calendar_date, com_yr_wk, com_start_date) VALUES ('2024-03-30', 12410, '2024-03-30');
INSERT INTO public.calendar_meta(calendar_date, com_yr_wk, com_start_date) VALUES ('2024-03-31', 12410, '2024-03-30');
